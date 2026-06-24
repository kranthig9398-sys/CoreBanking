package com.cb.builder;

public class CBUserDetailsBuilder {

	private int userId;
	private String username;
	private String password;
	private String roll;
	private String stateCode;
	private String loginLevel;

	private CBUserDetailsBuilder(Builder builder) {
		this.userId = builder.userId;
		this.username = builder.username;
		this.password = builder.password;
		this.roll = builder.roll;
		this.stateCode = builder.stateCode;
		this.loginLevel = builder.loginLevel;
	}

	public CBUserDetailsBuilder() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getLoginLevel() {
		return loginLevel;
	}

	public void setLoginLevel(String loginLevel) {
		this.loginLevel = loginLevel;
	}

	// Builder Class

	public static class Builder {

		private int userId;
		private String username;
		private String password;
		private String roll;
		private String stateCode;
		private String loginLevel;

		public Builder userId(int userId) {
			this.userId = userId;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder roll(String roll) {
			this.roll = roll;
			return this;
		}

		public Builder stateCode(String stateCode) {
			this.stateCode = stateCode;
			return this;
		}

		public Builder loginLevel(String loginLevel) {
			this.loginLevel = loginLevel;
			return this;
		}

		public CBUserDetailsBuilder build() {
			return new CBUserDetailsBuilder(this);
		}
	}
}