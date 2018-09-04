package com.example.jedis.controller;

import com.example.jedis.bean.Student;
import com.example.jedis.response.ResultClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/12
 */
@Api(value = "web端的接口 用于测试请求")
@RestController
@RequestMapping(value = "/stu")
public class StudentController {


    Logger logger = LoggerFactory.getLogger( StudentController.class );

    /**
     * 测试
     * @param student
     * @param
     * @return
     */
    @ApiOperation(value="添加用户", notes="根据User对象创建用户")
    @PostMapping(value = "/sava")
    @ResponseBody
    public ResultClient save( @RequestBody @Valid Student student, BindingResult result) throws Exception{
        logger.info( student+"" );
//          List<String> list1 = new ArrayList <>(  );
//        if(result.hasErrors()) {
//           List<ObjectError> list =  result.getAllErrors();
//           for (ObjectError ob:list) {
//               logger.info( ob +"");
//               //ob.getDefaultMessage()  获得具体的异常信息
//               list1.add( ob.getDefaultMessage() );
//           }
//        }
            return new ResultClient( student );
    }


    /**
     *
     * @param student
     * @param result
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据name和id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @PostMapping(value = "/find")
    @ResponseBody
    public Object finds(@RequestBody @Valid Student student, BindingResult result) {
        logger.info( "re"+student );
        System.out.println(student+"sd");
        return "ok";
    }



    /**
     *
     * @param student
     * @param id
     * @param result
     * @return
     */
    @ApiOperation(value="删除用户详细信息", notes="根据name和id来删除用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "student", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PostMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestBody @Valid Student student, @RequestBody Long id ,BindingResult result) {
        logger.info( "re"+student );
        System.out.println(student+"sd");
        return "ok";
    }






}
