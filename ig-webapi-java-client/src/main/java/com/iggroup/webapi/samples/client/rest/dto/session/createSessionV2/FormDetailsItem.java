package com.iggroup.webapi.samples.client.rest.dto.session.createSessionV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Form details
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormDetailsItem {

/*
Type of form
*/
private FormType formType;

/*
Form access url
*/
private String formUrl;

/*
Form title
*/
private String formTitle;

/*
Indicates if a user can dismiss the form
*/
private boolean formDismissible;

public FormType getFormType() { return formType; }
public void setFormType(FormType formType) { this.formType=formType; }
public String getFormUrl() { return formUrl; }
public void setFormUrl(String formUrl) { this.formUrl=formUrl; }
public String getFormTitle() { return formTitle; }
public void setFormTitle(String formTitle) { this.formTitle=formTitle; }
public boolean getFormDismissible() { return formDismissible; }
public void setFormDismissible(boolean formDismissible) { this.formDismissible=formDismissible; }
}
