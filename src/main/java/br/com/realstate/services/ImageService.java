package br.com.realstate.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.UUID;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

public class ImageService {

	public static final String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=realstate;"
			+ "AccountKey=cjUFI9VVEyVcYw1YgwDvk8qbHuFbiIlFoXtKN+ih2bVfRhimMaWFKXZ3CC4Rdh0WcaXrIdx8NMcMg+YbxtGi/w==";

	public static URI imageUpload(File foto) {
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
			CloudBlobClient serviceClient = account.createCloudBlobClient();

			// obtêm o nome do contêiner ou cria se ele não existir.
			CloudBlobContainer container = serviceClient.getContainerReference("imoveis");
			container.createIfNotExists();

			// Obtêm a extensão do arquivo
			String nome = foto.toString();
			String extensao = nome.substring(nome.lastIndexOf('.'), nome.length());
			
			// Gera nome aleatório para o blob.
			UUID uuid = UUID.randomUUID();
			String blobName = uuid.toString() + "-" + extensao;
			
			// Faz o upload da imagem para o contêiner especificado.
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			File sourceFile = new File(foto.toString());
			blob.upload(new FileInputStream(sourceFile), sourceFile.length());
			URI uri = blob.getUri();
			return uri;

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.print("FileNotFoundException encountered: ");
			System.out.println(fileNotFoundException.getMessage());
			System.exit(-1);
		} catch (StorageException storageException) {
			System.out.print("StorageException encountered: ");
			System.out.println(storageException.getMessage());
			System.exit(-1);
		} catch (Exception e) {
			System.out.print("Exception encountered: ");
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return null;
	}

}
