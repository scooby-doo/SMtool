package edu.SMtool.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.GoalService;

@Controller
@RequestMapping("index")
public class GoalController {
	
	@Autowired
	private GoalService goalService;
	
	@RequestMapping("/list")
	public String listGoals(Map<String, Object> map){
		map.put("goal", new Goal());
		map.put("goalList",goalService.getAllGoals());
		return "viewGoals";
	}

}
