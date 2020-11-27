package com.nss.assignment.model;

public class EmailForm {
		private String sender;
		private String receiver;
		private String body;

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public String getReceiver() {
			return receiver;
		}

		public void setReceiver(String rec) {
			this.receiver = rec;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}
}
