package com.rochano.runningapp.api;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.StorageOptions;

@Component
public class GoogleCloudFileUpload {

	@Value("${GCP_PROJECT_ID}")
	private String gcpProjectId;

	@Value("${GCP_CREDENTIALS_LOCATION}")
	private String gcpCredentials;

	@Value("${GCP_BUCKET}")
	private String gcpBucket;

	@Value("${GCP_IMAGE_URL}")
	private String gcpImageUrl;

	@Autowired
	ResourceLoader resourceLoader;

	public String upload(String filePath) {
		return upload(filePath, filePath);
	}

	public String upload(String filePath, String oldFilePath) {
		try {
			Resource resource = resourceLoader.getResource(gcpCredentials);
			InputStream inputStream = resource.getInputStream();
			Credentials credentials = GoogleCredentials.fromStream(inputStream);
			Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(gcpProjectId).build()
					.getService();
			Path oldPath = Paths.get(oldFilePath);
			Path path = Paths.get(filePath);
//			BufferedImage originalImage = ImageIO.read(new File(filePath));
//			BufferedImage destImage = Scalr.resize(originalImage, 100);
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			String ext = FilenameUtils.getExtension(oldPath.getFileName().toString());
//			ImageIO.write(destImage, ext, baos);
//			byte[] bytes = baos.toByteArray();

			if (!filePath.equals(oldFilePath)) {
				BlobId oldBlobId = BlobId.of(gcpBucket, oldPath.getFileName().toString());
				storage.delete(oldBlobId);
			}
			BlobId blobId = BlobId.of(gcpBucket, path.getFileName().toString());
			BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
			storage.create(blobInfo, Files.readAllBytes(path), // the file
					BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));

			return gcpImageUrl + path.getFileName().toString();
//			return blobInfo.getMediaLink();
		} catch (IllegalStateException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
