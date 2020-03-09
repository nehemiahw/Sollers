package com.sollers.cal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sollers.cal.domain.MyNumber;
import com.sollers.cal.persistence.MyNumberRepository;
import com.sollers.cal.service.MyNumberService;




@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
class ApplicationTests {

	@Autowired
    private MyNumberRepository numberRepository;
	
	@Autowired
	private MyNumberService numberService;
	
	@Test
	public void main() {
	      Application.main(new String[] {});
	}
	
    /**
     * Testing save method of MyNumberService
     */
   @Test
    public void testSaveNumber() {


        try {
        	MyNumber number = new MyNumber(1,1.1,2.1,3.0);
        	numberRepository.save(number);
        	
			Optional<MyNumber> optionalNumber = numberRepository.findById(1);
			MyNumber newNumber =optionalNumber.get();
			
			assertNotNull(newNumber);
			assertEquals(newNumber.getFirstNumber(), number.getFirstNumber());
			assertEquals(newNumber.getSecondNumber(), number.getSecondNumber());
			assertEquals(newNumber.getResult(), number.getResult());
			number.setFirstNumber(3.1);
			assertEquals((Double)3.1,number.getFirstNumber());
			number.setSecondNumber(5.0);
			assertEquals((Double)5.0,number.getSecondNumber());
			number.setResult(5.1);
			assertEquals((Double)5.1,number.getResult());
			number.setId(5);
			assertEquals((Integer)5,number.getId());
		
		
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   @Test
   public void testFindAll() {


       try {
       		MyNumber number = new MyNumber(1,1.2,2.0,3.0);
       		numberRepository.save(number);
			List<MyNumber> listNumber = numberRepository.findAll();
			
			assertNotNull(listNumber);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
   @Test
   public void testFindTop() {


       try {
       	
    	    Long count=numberRepository.count();
			Optional<MyNumber> optionalNumber = numberRepository.findTopByOrderByIdDesc();
			Long testNumber=new Long(optionalNumber.get().getId());
			assertEquals(count,testNumber);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
 }
   @Test
   public void testService() {


       try {
       	
      		MyNumber number = new MyNumber(1,1.1,2.0,3.0);

    	   numberService.save(number);
    	   List<MyNumber> myList =numberService.findAll();
    	   
			assertNotNull(myList);
			
			Optional<MyNumber> optionalNumber=numberService.findTop();
			assertNotNull(optionalNumber);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
 }
   
   @Test
   public void testAddSubtract() {
	   
	   assertEquals((Double)4.0,numberService.add(2.0,2.0));
	   assertEquals((Double)0.0,numberService.subtraction(2.0,2.0));

	   
	   
	   
   } 
   @Test
   public void testJsonObject() {
	   
	   assertNotNull(numberService.converToJson(1.1, 2.0, 3.0,"-"));
	   
	   
   }


}
