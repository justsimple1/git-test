package ru.job4j;


/**
 * Class для создания калькулятора.
 *
 * @author panin.nikita.
 * @since 24.03.2018.
 * @version 1.
 */
public class Calculate {
	/**
	 * result -Результат арифметических операций.
	 */
	private double result;

	/**
	 * Сложение
	 * @param first - первое значение.
	 * @param second - второе значение.
	 * this.result - результат.
	 */
	public void add(double first,double second){
		this.result = first + second;
	}
	/**
	 * Вычитание
	 * @param first - первое значение.
	 * @param second - второе значение.
	 * this.result - результат.
	 */
	public void sub(double first,double second){
		this.result = first - second;
	}
	/**
	 * Умножение
	 * @param first - первое значение.
	 * @param second - второе значение.
	 * this.result - результат.
	 */
	public void mul(double first,double second){
		this.result = first * second;
	}
	/**
	 * Деление
	 * @param first - первое значение.
	 * @param second - второе значение.
	 * this.result - результат.
	 */
	public void div(double first,double second){
		this.result = first / second;
	}

	public double getResult(){
		return this.result;
	}
	/**
	 * Main.
	 * @param args args.
	 */
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	/**
	 *Method echo.
	 *@param name yeah.
	 *return Echo yeah.
	 */
	public String echo(String name) {
		return  "Echo, echo, echo : " + name;
	}
}