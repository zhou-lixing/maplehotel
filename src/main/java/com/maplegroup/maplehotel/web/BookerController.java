package com.maplegroup.maplehotel.web;


import com.maplegroup.maplehotel.dao.IRoomTypeDao;
import com.maplegroup.maplehotel.entity.*;
import com.maplegroup.maplehotel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ly")
public class BookerController {

    @Autowired
    private IRoomReserveService roomReserveService;

    @Autowired
    private ICheckInRegistService checkInRegistService;

    @Autowired
    private ICheckOutAccountsService checkOutAccountsService;

    @Autowired
    private IChangeRoomService changeRoomService;

    @Autowired
    private IRoomTypeService roomTypeService;



    @RequestMapping("/index")
    public ModelAndView testIndex(){
        return new ModelAndView("../index");
    }


    @RequestMapping("/roomReserve")
    public ModelAndView test1(){
        return new ModelAndView("tenantManage/roomReserve");
    }
    @RequestMapping("/roomReserveLook")
    public ModelAndView test2(){
        return new ModelAndView("tenantManage/roomReserveLook");
    }
    @RequestMapping("/scheduledRegist")
    public ModelAndView test3(){
        return new ModelAndView("tenantManage/scheduledRegist");
    }


    @RequestMapping("/checkInRegistList")
    public ModelAndView test4(){
        return new ModelAndView("tenantManage/checkInRegistList");
    }
    @RequestMapping("/checkInLook")
    public ModelAndView test5(){
        return new ModelAndView("tenantManage/checkInLook");
    }
    @RequestMapping("/checkInRegist")
    public ModelAndView test6(){
        return new ModelAndView("tenantManage/checkInRegist");
    }
    @RequestMapping("/checkInRegistTwo")
    public ModelAndView test7(){
        return new ModelAndView("tenantManage/checkInRegistTwo");
    }


    @RequestMapping("/changeRoom")
    public ModelAndView test8(){
        return new ModelAndView("tenantManage/changeRoom");
    }


    @RequestMapping("/checkOutAccounts")
    public ModelAndView test9(){
        return new ModelAndView("tenantManage/checkOutAccounts");
    }
    @RequestMapping("/checkOutAccountsTwo")
    public ModelAndView test10(){
        return new ModelAndView("tenantManage/checkOutAccountsTwo");
    }

    //------------------------------------------------------------------------------------------

   /* @ResponseBody
    @RequestMapping("/showReserveInfo")
    public List<ReserveInfo> showReserveInfo(){
        //显示所有预订人
       return roomReserveService.findAllReserve();

    }*/

    @ResponseBody
    @RequestMapping("/showReserveInfoBy")
    //显示预订人信息
    public List<ReserveInfo> showReserveInfoBy(@RequestParam Map<String,String> map) {

        /*System.out.println(reserveInfoRoomNumber);
        System.out.println(reserveInfoBooker);
        if(reserveInfoRoomNumber!=null){
            return roomReserveService.findReserveByRoomNumber(reserveInfoRoomNumber);
        }else {
            return roomReserveService.findReserveByBooker(reserveInfoBooker);
        }*/

        return roomReserveService.find(map);

    }

    @ResponseBody
    @RequestMapping("/showCheckInInfoBy")
    //显示入住人信息
    public List<CheckInInfo> showCheckInInfoBy(@RequestParam Map<String,String> map) {



        return checkInRegistService.find(map);

    }




    /*@ResponseBody
    @RequestMapping("/showReserveInfoByBooker")
    public ReserveInfo showReserveInfoByBooker(String reserveInfoBooker){

        return roomReserveService.findReserveByBooker(reserveInfoBooker);

    }

    @ResponseBody
    @RequestMapping("/showReserveInfoByType")
    public List<ReserveInfo> showReserveInfoByRoomType(String reserveInfoRoomType){

        return roomReserveService.findReserveByType(reserveInfoRoomType);

    }*/

    //-----------------------------------------------------------------------------------------------

    @ResponseBody
    @RequestMapping("/showCheckInInfo")
    public List<CheckInInfo> showCheckInInfo(){
        //显示入住人信息
        return checkInRegistService.findAllCheckIn();

    }

    //---------------------------------------------------------------------------------------------------

    @ResponseBody
    @RequestMapping("/addReserve")
    public boolean addReserve(@RequestParam Map<String,String> map){
        //预定登记添加预定客户
        String maxIdOfOrderNum = (Integer.parseInt(roomReserveService.findMaxIdOfOrderNum().substring(2))+1)+"";
        String roomType = map.get("roomType");

        String human = map.get("human");
        String phone = map.get("phone");

        ReserveInfo reserveInfo=new ReserveInfo(0, "YD"+maxIdOfOrderNum, "106", roomType, new BigDecimal(129),
                new BigDecimal(120),new BigDecimal(100), human, "身份证", "130287158692547865",
                phone,"2019-09-17 18:24:32","2019-09-18 11:45:22", 1, "1003", "100003",
                new BigDecimal(80), "已预订", null, 0,null,null);

        Member member=new Member();
        member.setMemberName(human);
        member.setMemberSex("男");
        member.setMemberIdentifier("100006");
        member.setMemberPassword("123456");
        member.setMemberPhoneNumber("18232547989");
        member.setMemberAddress("河北省唐山市");
        member.setMemberDel(0);
        roomReserveService.addReserve(reserveInfo,member);
        return true;
    }

    @ResponseBody
    @RequestMapping("/addCheckIn")
    public boolean addCheckIn(@RequestParam Map<String,String> map){
        String maxIdOfCheckInNum = (Integer.parseInt(checkInRegistService.findMaxIdOfCheckInNum().substring(2))+1)+"";

        String human=map.get("human");
        BigDecimal deposit=new BigDecimal(Integer.parseInt(map.get("deposit")));
        String roomType=map.get("roomType");

        String idNum=map.get("idNum");
        String phone=map.get("phone");
        String arrivalTime=map.get("arrivalTime");
        String leaveTime=map.get("leaveTime");

        CheckInInfo checkInInfo=new CheckInInfo(0, "MH"+maxIdOfCheckInNum, "105", roomType, new BigDecimal(128),
                new BigDecimal(120),deposit, human, "身份证", idNum,
                phone,arrivalTime,leaveTime, 1, "1004", "100005",
                new BigDecimal(100), "是",null, null, 0,null,null);

        Member member=new Member();
        member.setMemberName(human);
        member.setMemberSex("男");
        member.setMemberIdentifier("100006");
        member.setMemberPassword("123456");
        member.setMemberPhoneNumber("18232547989");
        member.setMemberAddress("河北省唐山市");
        member.setMemberDel(0);

        checkInRegistService.addCheckIn(checkInInfo, member);

        return true;

    }

    @ResponseBody
    @RequestMapping("/checkOut")
    public boolean checkOut(@RequestParam Map<String,String> map){

        String roomType=map.get("roomType");
        BigDecimal homePrice=new BigDecimal(Integer.parseInt(map.get("homePrice")));
        BigDecimal shouldRefund=new BigDecimal(Integer.parseInt(map.get("shouldRefund")));
        String payMethod=map.get("payMethod");
        /*if(payMethod.equals("zfb")){
            payMethod="支付宝";
        }else if(payMethod.equals("wx")){
            payMethod="微信";

        }else if(payMethod.equals("yhk")){
            payMethod="银行卡";

        }else if(payMethod.equals("xj")){
            payMethod="现金";

        }*/
        System.out.println(map);
        BigDecimal receive=new BigDecimal(Integer.parseInt(map.get("receive")));
        int homeNum=Integer.parseInt(map.get("homeNum"));
        BigDecimal change=new BigDecimal(Integer.parseInt(map.get("change")));
        System.out.println(1);
        CheckOutAccounts checkOutAccounts=new CheckOutAccounts(0, "MH0003",
                "104",homePrice, new BigDecimal(120),homeNum, new BigDecimal(258),
                new BigDecimal(4), new BigDecimal(100), new BigDecimal(50), new BigDecimal(600),
                shouldRefund, payMethod,receive,change, "1002", null,
                0, "", null, null);

        System.out.println(checkOutAccounts);
        return checkOutAccountsService.addToCheckOut(checkOutAccounts);

    }


    @ResponseBody
    @RequestMapping("/changeRoomIndex")
    public boolean changeRoom(@RequestParam Map<String,String> map){

        String roomType=map.get("roomType");
        String beforeHomeNum=map.get("beforeHomeNum");
        String afterHomeNum=map.get("afterHomeNum");

        ChangeRoom changeRoom=new ChangeRoom(0, "MH0004", beforeHomeNum,afterHomeNum, roomType, new BigDecimal(89),
                new BigDecimal(80),new BigDecimal(100), "LAOZHAO", "身份证", "425798100295157239",
                "13212345676","2019-09-17 18:24:32","2019-09-18 11:45:22", 1, "1004", "100005",
                new BigDecimal(200), null,null, null, 0,null,null);
        changeRoomService.addToChange(changeRoom);

        return true;
    }
    //---------------------------------------------------------------------------------------------

    @RequestMapping("/findRoomType")
    @ResponseBody
    public List<RoomType> findRoomType(){
        return roomTypeService.findAll();
    }

    @RequestMapping("/cancelReserveStatus")
    @ResponseBody
    public ModelAndView cancelReserveStatus(String reserveInfoRoomNumber){
        roomReserveService.delReserve(reserveInfoRoomNumber);
        roomReserveService.cancelReserveStatus(reserveInfoRoomNumber);
        return new ModelAndView("tenantManage/roomReserve");
    }

    @ResponseBody
    @RequestMapping("/ReserveDetail/{roomNum}")
    public ReserveInfo reserveDetail(@PathVariable String roomNum){
        return roomReserveService.findReserveByRoomNumber(roomNum);
    }

    @ResponseBody
    @RequestMapping("/checkInDetail/{roomNum}")
    public CheckInInfo checkInDetail(@PathVariable String roomNum){
        return checkInRegistService.findCheckInByHomeNumber(roomNum);
    }

}
