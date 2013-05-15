package goal;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.GoalService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@TransactionConfiguration
@Transactional
public class GoalDAO {
	
	@Autowired
	GoalService goalService;
	
	private final int idGoal = 1;

	@Test
	public void addGoal() {
		assertNotNull(goalService);
		
		Goal goalTest = new Goal();
		goalTest.setDescription("testDescription");
		goalTest.setStatus("testStatus");
		goalTest.setComments("testCommnets");
		goalService.addGoal(goalTest);
		assertNotNull(goalTest.getId());
		Goal goalRetrieve = goalService.getGoalById(goalTest.getId());
		assertEquals(goalTest, goalRetrieve);
	}
	
	@Test
	public void getAllGoals(){
		List<Goal> goalList = goalService.getAllGoals();
		assertNotNull("list null", goalList);
	}
	
	@Test
	public void editGoal(){
		Goal goalOld= goalService.getGoalById(idGoal);
		goalOld.setComments("new comments");
		goalService.editGoal(goalOld);
		
		Goal goalNew = goalService.getGoalById(idGoal);
		assertEquals(goalNew, goalOld);
	}
	
	@Test
	public void deleteGoal(){
		Goal goalDelete = goalService.getGoalById(8);
		goalService.deleteGoal(goalDelete);
		
		Goal goalCheck = goalService.getGoalById(8);
		assertNull(goalCheck);
	}

}
