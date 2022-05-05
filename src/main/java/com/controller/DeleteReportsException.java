package com.controller;

public class DeleteReportsException {

		private int id;
		public  DeleteReportsException(int id) {
			
		super();
		this.id=id;
	}

	@Override
	public String toString() {
		return "id "+ id +" not available";
	}

	}

