package com.chaofan.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chaofan.common.utils.Result;
import com.chaofan.modules.tiku.model.QuestionAnswerEntity;
import com.chaofan.modules.tiku.service.IQuestionAnswerService;
import com.chaofan.utils.ShiroUtils;

@Controller
public class QuestionAnswerController {
	
	@Autowired
	private IQuestionAnswerService iQuestionAnswerService;

	@RequestMapping(value = "member/sendAnswer.html", method = RequestMethod.POST)
	@ResponseBody
	public Result sendAnswer(@RequestBody QuestionAnswerEntity entity){
		entity.setMemberAvatar(ShiroUtils.getMember().getAvatar());
		entity.setMemberId(ShiroUtils.getMemberId());
		entity.setMemberName(ShiroUtils.getMember().getNickName());
		iQuestionAnswerService.sendAnswer(entity);
		return Result.result(0, null, "保存成功");
	}
	
}
