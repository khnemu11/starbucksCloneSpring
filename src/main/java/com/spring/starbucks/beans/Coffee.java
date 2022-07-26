package com.spring.starbucks.beans;

import org.springframework.web.multipart.MultipartFile;

public class Coffee{
	private Long seq;
	private String name_kr;
	private String weight;
	private String name_en;
	private String price;
	private String type;
	private String description_summary;
	private String description_detail;
	private String design_story;
	private String coffee_tasting_note;
	private String tasting_notes;
	private String enjoy_with;
	private String relative;
	private String processing_method;
	private MultipartFile file;
	
	public String getRelative() {
		return relative;
	}
	public void setRelative(String relative) {
		this.relative = relative;
	}
	public String getEnjoy_with() {
		return enjoy_with;
	}
	public void setEnjoy_with(String enjoy_with) {
		this.enjoy_with = enjoy_with;
	}
	public String getTasting_notes() {
		return tasting_notes;
	}
	public void setTasting_notes(String tasting_notes) {
		this.tasting_notes = tasting_notes;
	}
	public String getCoffee_tasting_note() {
		return coffee_tasting_note;
	}
	public void setCoffee_tasting_note(String coffee_tasting_note) {
		this.coffee_tasting_note = coffee_tasting_note;
	}
	public String getDesign_story() {
		return design_story;
	}
	public void setDesign_story(String design_story) {
		this.design_story = design_story;
	}
	public String getDescription_detail() {
		return description_detail;
	}
	public void setDescription_detail(String description_detail) {
		this.description_detail = description_detail;
	}
	public String getDescription_summary() {
		return description_summary;
	}
	public void setDescription_summary(String description_summary) {
		this.description_summary = description_summary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getName_kr() {
		return name_kr;
	}
	public void setName_kr(String name_kr) {
		this.name_kr = name_kr;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getProcessing_method() {
		return processing_method;
	}
	public void setProcessing_method(String processing_method) {
		this.processing_method = processing_method;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
}