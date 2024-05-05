package org.design;

import java.io.Serializable;

public class ClusterLicense implements Serializable {

	private static final long serialVersionUID = 6823988728452646785L;

	private String clusterId;
	private String licenseKey;

	public ClusterLicense(String clusterId, String licenseKey) {
		super();
		this.clusterId = clusterId;
		this.licenseKey = licenseKey;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	@Override
	public String toString() {
		return "ClusterLicense{" +
				"clusterId='" + clusterId + '\'' +
				", licenseKey='" + licenseKey + '\'' +
				'}';
	}
}
