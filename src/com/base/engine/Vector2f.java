package com.base.engine;

public class Vector2f {
	private float x;
	private float y;

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public float dot(Vector2f r) {
		return x * r.getX() + y * r.getY();
	}

	public Vector2f normalize() {
		float length = length();

		x /= length;
		y /= length;

		return this;
	}

	public Vector2f rotate(float angle) {
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);

		return new Vector2f((float) (x * cos - y * sin), (float) (x * sin + y * cos));
	}

	// add
	public Vector2f add(Vector2f r) {
		return new Vector2f(x + r.getX(), y + r.getY());
	}

	public Vector2f add(float r) {
		return new Vector2f(x + r, y + r);
	}

	// subtract
	public Vector2f sub(Vector2f r) {
		return new Vector2f(x - r.getX(), y - r.getY());
	}

	public Vector2f sub(float r) {
		return new Vector2f(x - r, y - r);
	}

	// multiply
	public Vector2f mul(Vector2f r) {
		return new Vector2f(x * r.getX(), y * r.getY());
	}

	public Vector2f mul(float r) {
		return new Vector2f(x * r, y * r);
	}

	// divide
	public Vector2f div(Vector2f r) {
		return new Vector2f(x / r.getX(), y / r.getY());
	}

	public Vector2f dib(float r) {
		return new Vector2f(x / r, y / r);
	}

	// print
	public String toString() {
		return "(" + x + " " + y + ")";
	}

	// get
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	// set
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
}
