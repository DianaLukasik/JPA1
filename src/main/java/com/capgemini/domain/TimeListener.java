package com.capgemini.domain;


import java.sql.Date;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;


public class TimeListener {

	  private Date created;
	  private Date updated;

//	  @PostPersist
//	  protected void onCreate() {
//	    created = new Date();
//	  }
//
//	  @PostUpdate
//	  protected void onUpdate() {
//	    updated = new Date();
//	  }
}
