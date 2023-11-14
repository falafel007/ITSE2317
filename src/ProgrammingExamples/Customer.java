package ProgrammingExamples;

public class Customer
{
	private final String cusName;
	private final String cusPhoneNo;
	
	Customer(String cusName, String cusPhoneNo)
	{
		this.cusName = cusName;
		this.cusPhoneNo = cusPhoneNo;
	}

	public String getCusName()
	{
		return cusName;
	}

	public String getCusPhoneNo()
	{
		return cusPhoneNo;
	}
}