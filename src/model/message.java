package model;

public class message {
	
	private int receiverId;
	private int senderId;
	private int messageId;
	private static int next_messageId;
	private String message;
	public message() {
		
	}
	public message(int receiverId, int senderId, String message) {
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.message = message; 
		this.messageId = next_messageId;
		next_messageId++;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
