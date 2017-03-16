package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
	public abstract class AbstractEntity {
		@Version
		@Column(name = "version", columnDefinition = "int default 0")
		private int version;

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}
	}

