package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest
{

	@Test
	public void getPoint() throws Exception
	{
		TwoPoints testPoints = new TwoPoints();
		Point p1 = testPoints.getPoint(0);
		Point p2 = testPoints.getPoint(1);
		assertEquals(p1.x, 0);
		assertEquals(p1.y, 0);
		assertEquals(p2.x, 0);
		assertEquals(p2.y, 0);
	}

	@Test
	public void setPoint()
	{
		TwoPoints testPoints = new TwoPoints();
		testPoints.setPoint(0, 5, -3);
		testPoints.setPoint(1, -3, 5);
		Point p1 = testPoints.getPoint(0);
		Point p2 = testPoints.getPoint(1);
		assertEquals(p1.x, 5);
		assertEquals(p1.y, -3);
		assertEquals(p2.x, -3);
		assertEquals(p2.y, 5);
	}

	@Test
	public void randomValue()
	{
		// create a new TwoPoints object
		TwoPoints test_points = new TwoPoints();

		// pull the points out the the TwoPoints object, and assign them to p0 & p1
		Point p0 = test_points.getPoint(0);
		Point p1 = test_points.getPoint(1);

		// test that they are initially both at the origin
		assertEquals(0, p0.x);
		assertEquals(0, p0.y);
		assertEquals(0, p1.x);
		assertEquals(0, p1.y);

		// call the randomValue() method on both points
		test_points.randomValue(0);
		test_points.randomValue(1);

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that p0 & p1's x & y member variables are within correct boundaries
		assertEquals(true, ( (9 >= p0.x) && (p0.x >= -10) ) );
		assertEquals(true, ( (9 >= p0.y) && (p0.y >= -10) ) );
		assertEquals(true, ( (9 >= p1.x) && (p1.x >= -10) ) );
		assertEquals(true, ( (9 >= p1.y) && (p1.y >= -10) ) );
	}

	@Test
	public void setOrigin()
	{
		// create a new TwoPoints object
		TwoPoints test_points = new TwoPoints();

		// pull the points out the the TwoPoints object, and assign them to p0 & p1
		Point p0 = test_points.getPoint(0);
		Point p1 = test_points.getPoint(1);

		// test that they are initially both at the origin
		assertEquals(0, p0.x);
		assertEquals(0, p0.y);
		assertEquals(0, p1.x);
		assertEquals(0, p1.y);

		// change both points' position to be something other than the origin
		test_points.setPoint(0, 5, -3);
		test_points.setPoint(1, -3, 5);

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that both points' member variables x & y were successfully set by setPoint()
		assertEquals(p0.x, 5);
		assertEquals(p0.y, -3);
		assertEquals(p1.x, -3);
		assertEquals(p1.y, 5);

		// call the setOrigin() method on both points
		test_points.setOrigin(0);
		test_points.setOrigin(1);

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that both points are at the origin once again
		assertEquals(0, p0.x);
		assertEquals(0, p0.y);
		assertEquals(0, p1.x);
		assertEquals(0, p1.y);
	}

	@Test
	public void copy()
	{
		// create a new TwoPoints object
		TwoPoints test_points = new TwoPoints();

		// pull the points out the the TwoPoints object, and assign them to p0 & p1
		Point p0 = test_points.getPoint(0);
		Point p1 = test_points.getPoint(1);

		// test that they are initially both at the origin
		assertEquals(0, p0.x);
		assertEquals(0, p0.y);
		assertEquals(0, p1.x);
		assertEquals(0, p1.y);

		// change both points' position to be something other than the origin
		test_points.setPoint(0, 5, -3);
		test_points.setPoint(1, -3, 5);

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that both points' member variables x & y were successfully set by setPoint()
		assertEquals(p0.x, 5);
		assertEquals(p0.y, -3);
		assertEquals(p1.x, -3);
		assertEquals(p1.y, 5);

		// call the copy() method on p0
		Point temp = test_points.getPoint(0);
		test_points.copy(1, 0);

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that p0 was overwritten by p1
		assertEquals(p0.x, -3);
		assertEquals(p0.y, 5);
		assertEquals(p1.x, -3);
		assertEquals(p1.y, 5);

		// call the copy() method on p1
		test_points.setPoint(0, temp.x, temp.y);
		test_points.copy(0, 1);

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that p1 was overwritten by p0
		assertEquals(p0.x, 5);
		assertEquals(p0.y, -3);
		assertEquals(p1.x, 5);
		assertEquals(p1.y, -3);
	}

	@Test
	public void distance()
	{
		// create a new TwoPoints object
		TwoPoints test_points = new TwoPoints();

		// pull the points out the the TwoPoints object, and assign them to p0 & p1
		Point p0 = test_points.getPoint(0);
		Point p1 = test_points.getPoint(1);

		// test that they are initially both at the origin
		assertEquals(0, p0.x);
		assertEquals(0, p0.y);
		assertEquals(0, p1.x);
		assertEquals(0, p1.y);

		// change both points' position to be something other than the origin
		test_points.setPoint(0, 39, 27);
		test_points.setPoint(1, 13, 5);
		// xDiff should be int 26
		// yDiff should be int 22
		// distance should return double 34

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that both points' member variables x & y were successfully set by setPoint()
		assertEquals(p0.x, 39);
		assertEquals(p0.y, 27);
		assertEquals(p1.x, 13);
		assertEquals(p1.y, 5);

		// call the distance() method
		double distance = test_points.distance();

		// test that the distance() method correctly calculated the distance between p0 & p1
		assertEquals(34, distance, 0);
	}

	@Test
	public void slope()
	{
		// create a new TwoPoints object
		TwoPoints test_points = new TwoPoints();

		// pull the points out the the TwoPoints object, and assign them to p0 & p1
		Point p0 = test_points.getPoint(0);
		Point p1 = test_points.getPoint(1);

		// test that they are initially both at the origin
		assertEquals(0, p0.x);
		assertEquals(0, p0.y);
		assertEquals(0, p1.x);
		assertEquals(0, p1.y);

		// change both points' position to be something other than the origin
		test_points.setPoint(0, 39, 27);
		test_points.setPoint(1, 13, 5);
		// xDiff should be int 26
		// yDiff should be int 22
		// slope should return double 0.846154

		// update p0 & p1
		p0 = test_points.getPoint(0);
		p1 = test_points.getPoint(1);

		// test that both points' member variables x & y were successfully set by setPoint()
		assertEquals(p0.x, 39);
		assertEquals(p0.y, 27);
		assertEquals(p1.x, 13);
		assertEquals(p1.y, 5);

		// call the slope() method
		double slope = test_points.slope();

		// test that the slope() method correctly calculated the slope between p0 & p1
		assertEquals(0.846154, slope, 0.000001);
	}
}