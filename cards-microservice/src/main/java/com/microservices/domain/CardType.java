package com.microservices.domain;

public enum CardType {
	VISA {
		@Override
		public String toString() {
			return "VISA";
		}
	}, 
	MASTERCARD {
		@Override
		public String toString() {
			return "MASTERCARD";
		}
	}, 
	DISCOVER {
		@Override
		public String toString() {
			return "DISCOVER";
		}
	}, 
	AMERICANEXPRESS {
		@Override
		public String toString() {
			return "AMERICANEXPRESS";
		}
	}, 
	DINERSCLUB {
		@Override
		public String toString() {
			return "DINERSCLUB";
		}
	}, 
	JCB {
		@Override
		public String toString() {
			return "JCB";
		}
	}
}
