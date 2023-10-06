package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;




class TestDemoJUnitTest {
	@Test
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(5, 7, 12, false),
				arguments(0, -3, -3, true),
				arguments(11, 14, 25, false)
				);
	}
	static Stream<Arguments> argumentsForTheseMakeFive(){
		return Stream.of(
				arguments(4, 1, 5, false),
				arguments(2, 3, 5, false),
				arguments(-5, 10, 5, false),
				arguments(100, 90, 190, true),
				arguments(3, 9, 12, true)
				);
	}

	
	private TestDemo testDemo;
	private TestDemo testDemo2; //created new testDemo to not confuse the two

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		testDemo2 = new TestDemo(); //setup new testDemo
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPostive2(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPostive2(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	@ParameterizedTest
    @MethodSource("argumentsForTheseMakeFive") //is using the proper method for the Paramerterized Test
	void assertThatTheseTwoMakeFive(int a, int b, int expected, boolean expectException) {
		if (!expectException) { //if we do no expect an Exception from the two int...
			assertThat(testDemo2.theseMakeFive(a, b)).isEqualTo(expected); //verify that both int are equal to what is expected...
		}else {
			assertThatThrownBy(() -> testDemo2.theseMakeFive(a, b)).isInstanceOfAny(IllegalArgumentException.class); //otherwise, assert that it is an IllegalArgumentException
		}
	}

	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared(mockDemo.getRandomInt());
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
}


