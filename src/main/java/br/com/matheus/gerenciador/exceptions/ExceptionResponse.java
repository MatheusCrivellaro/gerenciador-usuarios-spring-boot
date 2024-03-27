package br.com.matheus.gerenciador.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime timestamp;
	private String message;
	private String details;
	private String descricaoPersonalizada;
	
	public ExceptionResponse(LocalDateTime timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ExceptionResponse(LocalDateTime timestamp, String message, String details, String descricaoPersonalizada) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.descricaoPersonalizada = descricaoPersonalizada;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
