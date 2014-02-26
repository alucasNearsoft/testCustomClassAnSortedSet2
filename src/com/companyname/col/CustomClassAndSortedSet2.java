package com.companyname.col;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * the false value (resulting from the equals()
comparison) also shows that the sorted set’s natural ordering is inconsistent with equals(), which
violates SortedSet’s contract:
The ordering maintained by a sorted set (whether or not an explicit comparator is provided) must be
consistent with equals() if the sorted set is to correctly implement the Set interface. This is so because the
Set interface is defined in terms of the equals() operation, but a sorted set performs all element
comparisons using its compareTo() (or compare()) method, so two elements that are deemed equal by this
method are, from the standpoint of the sorted set, equal
 *
 */
class CustomClassAndSortedSet2
{
	public static void main(String[] args)
	{
		SortedSet<Employee> sse = new TreeSet<>();
		sse.add(new Employee("Sally Doe"));
		sse.add(new Employee("Bob Doe"));
		Employee e1 = new Employee("John Doe");
		Employee e2 = new Employee("John Doe");
		sse.add(e1);
		sse.add(e2);
		System.out.println(sse);
		System.out.println(e1.equals(e2));
	}
}

class Employee implements Comparable<Employee>
{
	private String name;
	Employee(String name)
	{
		this.name = name;
	}
	@Override
	public int compareTo(Employee e)
	{
		return name.compareTo(e.name);
	}
	@Override
	public String toString()
	{
		return name;
	}
}