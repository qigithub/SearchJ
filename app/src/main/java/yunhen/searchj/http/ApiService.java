package yunhen.searchj.http;

import com.mrwater.worker.constant.NetConstantValue;
import com.mrwater.worker.entity.AbandonTaskReq;
import com.mrwater.worker.entity.ActualtaskReq;
import com.mrwater.worker.entity.BoxNumReq;
import com.mrwater.worker.entity.BucketRecycInfoReq;
import com.mrwater.worker.entity.BuildingIdReq;
import com.mrwater.worker.entity.BuildingUserIdReq;
import com.mrwater.worker.entity.ChangePwdReq;
import com.mrwater.worker.entity.CheckVersionReq;
import com.mrwater.worker.entity.CodeIdReq;
import com.mrwater.worker.entity.CreateTaskReq;
import com.mrwater.worker.entity.DelayTaskReq;
import com.mrwater.worker.entity.DepositCheckReq;
import com.mrwater.worker.entity.EditWorkMsgReq;
import com.mrwater.worker.entity.FindTaskDayReq;
import com.mrwater.worker.entity.FinishBucketRecycleReq;
import com.mrwater.worker.entity.FinishInfoReq;
import com.mrwater.worker.entity.GetCodeIdReq;
import com.mrwater.worker.entity.HandoverListReq;
import com.mrwater.worker.entity.HandoverReq;
import com.mrwater.worker.entity.IdReq;
import com.mrwater.worker.entity.LastIdCountReq;
import com.mrwater.worker.entity.LoginReq;
import com.mrwater.worker.entity.MyTaskBuildingInfoReq;
import com.mrwater.worker.entity.MyTaskFinishInfoReq;
import com.mrwater.worker.entity.MyTasksReq;
import com.mrwater.worker.entity.OldPwdReq;
import com.mrwater.worker.entity.OrderIdReq;
import com.mrwater.worker.entity.RecordAddReq;
import com.mrwater.worker.entity.RecordIdReq;
import com.mrwater.worker.entity.RecordUpReq;
import com.mrwater.worker.entity.RefreshTaskStatusReq;
import com.mrwater.worker.entity.ResetPasswordReq;
import com.mrwater.worker.entity.SendSmsReq;
import com.mrwater.worker.entity.ServiceTaskFinishReq;
import com.mrwater.worker.entity.ServiceTaskStatusReq;
import com.mrwater.worker.entity.SetPreTaskReq;
import com.mrwater.worker.entity.ShopIdReq;
import com.mrwater.worker.entity.TaskCenterAllGetReq;
import com.mrwater.worker.entity.TaskCenterBuildReq;
import com.mrwater.worker.entity.TaskCenterFloorGetReq;
import com.mrwater.worker.entity.TaskGeTaskReq;
import com.mrwater.worker.entity.TaskIdReasonReq;
import com.mrwater.worker.entity.TimeReq;
import com.mrwater.worker.entity.UnFinishTaskReq;
import com.mrwater.worker.entity.UpdateWaterDeliveryReq;
import com.mrwater.worker.entity.UploadLocationReq;
import com.mrwater.worker.entity.ValidateReq;
import com.mrwater.worker.entity.WorkerCheckSmsReq;
import com.mrwater.worker.entity.WorkerRegisterReq;
import com.mrwater.worker.model.CityBean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dongqi on 2016/8/10.
 * 服务器地址后缀
 */
public interface ApiService {
    /*
    * 括号里的不要以/开头
    * @FormUrlEncoded
    *
    * @Multipart
    * */
//    @POST("/login/")
//    Observable<LoginResp> login(@Body LoginReq baseResponse);
//
//    @POST("/getSmsCode")
//    Observable<GetSmsCodeResp> getSmsCode(@Body GetSmsCodeReq b);


    /**
     * 注意1：必须使用{@code @POST}注解为post请求<br>
     * 注意：使用{@code @Multipart}注解方法，必须使用{@code @Part}/<br>
     * {@code @PartMap}注解其参数<br>
     * 本接口中将文本数据和文件数据分为了两个参数，是为了方便将封装<br>
     * {@link MultipartBody.Part}的代码抽取到工具类中<br>
     * 也可以合并成一个{@code @Part}参数
     * @param params 用于封装文本数据
     * @param parts 用于封装文件数据
     * @return BaseResp为服务器返回的基本Json数据的Model类
     */
//    @Multipart
//    @POST(MyConstants.UPLOAD_WORK)
//    Observable<String> requestUploadWork(@PartMap Map<String, RequestBody> params,
//                                         @Part List<MultipartBody.Part> parts);

    /**
     * 注意1：必须使用{@code @POST}注解为post请求<br>
     * 注意2：使用{@code @Body}注解参数，则不能使用{@code @Multipart}注解方法了<br>
     * 直接将所有的{@link MultipartBody.Part}合并到一个{@link MultipartBody}中
     */
//    @POST(MyConstants.UPLOAD_WORK)
//    Observable<String> requestUploadWork(@Body MultipartBody body);
//    @FormUrlEncoded

    /**
     * 版本检测接口
     * @param j
     * @return
     */
    @POST(NetConstantValue.CHECK_VERSION)
    Observable<String> CHECK_VERSION(@Body CheckVersionReq j);

    /**
     *
     * @param db 服务器(正式还是测试)
     * @param type  固定值"worker"
     * @return
     */
    @GET(NetConstantValue.APP_HOST_END)
    Observable<CityBean> APP_HOST(@Query("db") String db, @Query("type") String type);


    /**
     * 登陆接口
     * @param j
     * @return
     */
    @POST(NetConstantValue.WORKER_LOGIN)
    Observable<String> WORKER_LOGIN(@Body LoginReq j);

    /**
     * 验证手机是否能注册
     * @param j
     * @return
     */
    @POST(NetConstantValue.WORKER_VALIDATE)
    Observable<String> WORKER_VALIDATE(@Body ValidateReq j);

    /**
     * 发送验证码(手机得到验证码)
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_SEND_SMS)
    Observable<String> WORKER_SEND_SMS(@Body SendSmsReq req);

    /**
     * 检查验证码正确
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_CHECK_SMS)
    Observable<String> WORKER_CHECK_SMS(@Body WorkerCheckSmsReq req);

    /**
     * 注册
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_REGISTER)
    Observable<String> WORKER_REGISTER(@Body WorkerRegisterReq req);

    /**
     * 图片上传
     * @param json
     * @param file
     * @return
     */
    @Multipart
    @POST(NetConstantValue.WORKER_UPLOAD_IMAGE)
    Observable<String> WORKER_UPLOAD_IMAGE(@Part("json") RequestBody json,
                                           @Part MultipartBody.Part file);

    /**
     *更新水兵信息
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_EDIT_WORKER_INFO)
    Observable<String> WORKER_EDIT_WORKER_INFO(
            @Body EditWorkMsgReq req
    );

    /**
     * 上报经纬度
     * @param req
     * @return
     */
    @POST(NetConstantValue.UPDATE_POSITION)
    Observable<String> UPDATE_POSITION(@Body UploadLocationReq req);

    /**
     * 领取任务(订单)
     * @param req
     * @return
     */
    @POST(NetConstantValue.TASK_GET_TASK)
    Observable<String> TASK_GET_TASK(@Body TaskGeTaskReq req);

    /**
     * 我的任务完成进度情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.MY_TASK_FINISH_INFO)
    Observable<String> MY_TASK_FINISH_INFO(@Body MyTaskFinishInfoReq req);

    /**
     * 我的任务中单幢楼的详情
     * @return
     */
    @POST(NetConstantValue.MY_TASK_BUILDING_INFO)
    Observable<String> MY_TASK_BUILDING_INFO(@Body MyTaskBuildingInfoReq req);

    /**
     *任务中心每幢楼的任务完成信息和汇总信息
     * @return
     */
    @POST(NetConstantValue.TASK_CENTER_BUILDING_INFO)
    Observable<String> TASK_CENTER_BUILDING_INFO(@Body BaseRequest req);

    /**
     * 任务中心任务批量领取
     * @param req
     * @return
     */
    @POST(NetConstantValue.TASK_CENTER_ALL_GET)
    Observable<String> TASK_CENTER_ALL_GET(@Body TaskCenterAllGetReq req);

    /**
     * 服务任务查看商户状态
     * @return
     */
    @POST(NetConstantValue.SERVICE_TASK_NEED_USER_STATUS)
    Observable<String> SERVICE_TASK_NEED_USER_STATUS(@Body ServiceTaskStatusReq req);


    /**
     * 完成服务任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.SERVICE_TASK_FINISH)
    Observable<String> SERVICE_TASK_FINISH(@Body ServiceTaskFinishReq req);

    /**
     * 我的任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.MY_TASKS)
    Observable<String> MY_TASKS(@Body MyTasksReq req);

    /**
     *获取当前商户空桶的回收详情
     * @return
     */
    @POST(NetConstantValue.BUCKET_RECYCLE_INFO)
    Observable<String> BUCKET_RECYCLE_INFO(@Body BucketRecycInfoReq req);

    /**
     *
     * @param req
     * @return
     */
    @POST(NetConstantValue.ABANDON_TASK)
    Observable<String> ABANDON_TASK(@Body AbandonTaskReq req);

    /**
     * 完成空桶回收任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.FINISH_BUCKET_RECYCLE)
    Observable<String> FINISH_BUCKET_RECYCLE(@Body FinishBucketRecycleReq req);

    /**
     * 检测押金是否足够这次任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.DEPOSIT_CHECK)
    Observable<String> DEPOSIT_CHECK(@Body DepositCheckReq req);

    /**
     *
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_TASK_HAVE_HEAVYANDEMPTY_BUCKET)
    Observable<String> FINISH_INFO(@Body FinishInfoReq req);

    /**
     * 和DEPOSIT_CHECK 一样的请求参数
     * 门店担保送水
     * @param req
     * @return
     */
    @POST(NetConstantValue.GUARANTEE_SEND_WATER)
    Observable<String> GUARANTEE_SEND_WATER(@Body DepositCheckReq req);

    /**
     * 将任务延迟
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_TASK_DELAY)
    Observable<String> GET_TASK_DELAY(@Body DelayTaskReq req);


    /**
     * 查询预约任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.FIND_PRE_TASK_BY_DAY)
    Observable<String> FIND_PRE_TASK_BY_DAY(@Body FindTaskDayReq req);

    /**
     * 设置预约任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.SET_PRE_TASK)
    Observable<String> SET_PRE_TASK(@Body SetPreTaskReq req);

    /**
     * 取消任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.CANCEL_TASK)
    Observable<String> CANCEL_TASK(@Body UnFinishTaskReq req);

    /**
     * 刷新任务情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.REFRESH_TASK_STATUS)
    Observable<String> REFRESH_TASK_STATUS(@Body RefreshTaskStatusReq req);

    /**
     * 微信支付完毕与否
     * @param req
     * @return
     */
    @POST(NetConstantValue.IS_PAY_WEIXIN_FINISH)
    Observable<String> IS_PAY_WEIXIN_FINISH(@Body IdReq req);

    /**
     * 任务中心每幢楼的所有任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.TASK_CENTER_BUILDING_TASK)
    Observable<String> TASK_CENTER_BUILDING_TASK(@Body TaskCenterBuildReq req);

    /**
     * 指定写字楼的楼层情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_FLOOR)
    Observable<String> GET_FLOOR(@Body BuildingIdReq req);


    /**
     * 任务中心任务按层领取
     * @param req
     * @return
     */
    @POST(NetConstantValue.TASK_CENTER_FLOOR_GET)
    Observable<String> TASK_CENTER_FLOOR_GET(@Body TaskCenterFloorGetReq req);


    /**
     * 交接水桶－－统计桶数
     * @param req
     * @return
     */
    @POST(NetConstantValue.HANDOVER_SUB)
    Observable<String> HANDOVER_SUB(@Body BaseRequest req);


    /**
     * 交接水桶－－获取列表
     * @param req
     * @return
     */
    @POST(NetConstantValue.HANDOVER_LIST)
    Observable<String> HANDOVER_LIST(@Body HandoverListReq req);


    /**
     * 交接水桶－－商品拥有情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.GOODS_COUNT_LIST)
    Observable<String> GOODS_COUNT_LIST(@Body BaseRequest req);

    /**
     * 交接水桶－－商品ID列表
     * @param req
     * @return
     */
    @POST(NetConstantValue.GOODS_ID_LIST)
    Observable<String> GOODS_ID_LIST(@Body BaseRequest req);

    /**
     *交接水桶－－获得二维码Id
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_CODE)
    Observable<String> GET_CODE(@Body GetCodeIdReq req);

    /**
     * 交接水桶－－获得对应的交接记录
     * @param req
     * @return
     */
    @POST(NetConstantValue.FIND_CODE)
    Observable<String> FIND_CODE(@Body CodeIdReq req);

    /**
     * 交接水桶
     * @param req
     * @return
     */
    @POST(NetConstantValue.HANDOVER)
    Observable<String> HANDOVER(@Body HandoverReq req);

    /**
     * 获取用户资料
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_MY_INFO)
    Observable<String> GET_MY_INFO(@Body BaseRequest req);


    /**
     *
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_LOGOUT)
    Observable<String> WORKER_LOGOUT(@Body BaseRequest req);


    /**
     * 我的空桶任务信息
     * @param req
     * @return
     */
    @POST(NetConstantValue.BUCKET_RECYCLE_MY_BUILDING_INFO)
    Observable<String> BUCKET_RECYCLE_MY_BUILDING_INFO(@Body BaseRequest req);


    /**
     * 明日任务预估
     * @param req
     * @return
     */
    @POST(NetConstantValue.NEXT_DAY_TASK)
    Observable<String> NEXT_DAY_TASK(@Body BaseRequest req);

    /**
     * 单条任务详情
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_TASK_DETAIL)
    Observable<String> GET_TASK_DETAIL(@Body OrderIdReq req);

    /**
     * 空桶任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.BUCKET_RECYCLE_FOR_BUILDING)
    Observable<String> BUCKET_RECYCLE_FOR_BUILDING(@Body BuildingIdReq req);


    /**
     * 微信支付押金
     * @param req
     * @return
     */
    @POST(NetConstantValue.DEPOSIT_WEIXIN)
    Observable<String> DEPOSIT_WEIXIN(@Body DepositCheckReq req);

    /**
     * 现金支付押金
     * @param req
     * @return
     */
    @POST(NetConstantValue.DEPOSIT_CASH_PAYMENT)
    Observable<String> DEPOSIT_CASH_PAYMENT(@Body DepositCheckReq req);

    /**
     * 重置密码
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_RESET_PASSWORD)
    Observable<String> WORKER_RESET_PASSWORD(@Body ResetPasswordReq req);

    /**
     *历史任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.TASK_HISTORY_LIST)
    Observable<String> TASK_HISTORY_LIST(@Body TimeReq req);


    /**
     * 实际完成情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_FINISH_ACTUAL_TASK)
    Observable<String> GET_FINISH_ACTUAL_TASK(@Body ActualtaskReq req);

    /**
     * 收入情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_INCOME_SITUATION)
    Observable<String> GET_INCOME_SITUATION(@Body BaseRequest req);

    /**
     * 完成送重桶任务收入
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_FINISH_HEAVY_INCOME)
    Observable<String> GET_FINISH_HEAVY_INCOME(@Body LastIdCountReq req);

    /**
     * 完成收空桶任务收入
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_FINISH_EMPTY_INCOME)
    Observable<String> GET_FINISH_EMPTY_INCOME(@Body LastIdCountReq req);

    /**
     *拉取通知
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_NOTIFY)
    Observable<String> GET_NOTIFY(@Body LastIdCountReq req);

    /**
     * 获取配置信息，如客服电话号等
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_CONFIG)
    Observable<String> GET_CONFIG(@Body BaseRequest req);

    /**
     * 任务中心所有的实时任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.TASK_CENTER_ALL_REALTIME)
    Observable<String> TASK_CENTER_ALL_REALTIME(@Body BaseRequest req);

    /**
     * 激活用户
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_USER_ACTIVATE)
    Observable<String> WORKER_USER_ACTIVATE(@Body BaseRequest req);

    /**
     *取消服务任务
     * @param req
     * @return
     */
    @POST(NetConstantValue.SERVICE_TASK_CANCEL)
    Observable<String> SERVICE_TASK_CANCEL(@Body TaskIdReasonReq req);

    /**
     * 检测旧密码
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_CHECK_OLD_PASSWORD)
    Observable<String> WORKER_CHECK_OLD_PASSWORD(@Body OldPwdReq req);

    /**
     * 修改密码
     * @param req
     * @return
     */
    @POST(NetConstantValue.WORKER_CHANGE_PASSWORD)
    Observable<String> WORKER_CHANGE_PASSWORD(@Body ChangePwdReq req);

    /**
     * 申请商户
     * @param req
     * @return
     */
    @POST(NetConstantValue.APPLY_SHOP)
    Observable<String> APPLY_SHOP(@Body ShopIdReq req);

    /**
     * 检查商戶申请情况
     * @param req
     * @return
     */
    @POST(NetConstantValue.CHECK_SHOP)
    Observable<String> CHECK_SHOP(@Body ShopIdReq req);


    /**
     *
     * @param req
     * @return
     */
    @POST(NetConstantValue.GET_RECORD_LIST)
    Observable<String> GET_RECORD_LIST(@Body LastIdCountReq req);


    /**
     *
     * @param req
     * @return
     */
    @POST(NetConstantValue.STORAGE_RECORD_ADD)
    Observable<String> STORAGE_RECORD_ADD(@Body RecordAddReq req);

    @POST(NetConstantValue.STORAGE_RECORD_GET_RECORD_INFO)
    Observable<String> STORAGE_RECORD_GET_RECORD_INFO(@Body RecordIdReq req);

    @POST(NetConstantValue.GET_AVAILABLE_BUILDING)
    Observable<String> GET_AVAILABLE_BUILDING(@Body BaseRequest req);

    @POST(NetConstantValue.STORAGE_RECORD_UPDATE)
    Observable<String> STORAGE_RECORD_UPDATE(@Body RecordUpReq req);

    @POST(NetConstantValue.STORAGE_RECORD_DELETE)
    Observable<String> STORAGE_RECORD_DELETE(@Body RecordIdReq req);

    @POST(NetConstantValue.STORAGE_RECORD_CHECK_BOX)
    Observable<String> STORAGE_RECORD_CHECK_BOX(@Body BoxNumReq req);

    /**
     *
     * @param req
     * @return
     */
    @POST(NetConstantValue.WATER_DELIVERY_TASK_LIST)
    Observable<String> WATER_DELIVERY_TASK_LIST(@Body LastIdCountReq req);

    @POST(NetConstantValue.UPDATE_WATER_DELIVERY)
    Observable<String> UPDATE_WATER_DELIVERY(@Body UpdateWaterDeliveryReq req);

   @POST(NetConstantValue.WATER_DELIVERY_CREATE_TASK)
    Observable<String> WATER_DELIVERY_CREATE_TASK(@Body CreateTaskReq req);

    @POST(NetConstantValue.ROOM_NUM_IN_BUILDING)
    Observable<String> ROOM_NUM_IN_BUILDING(@Body BuildingIdReq req);

    @POST(NetConstantValue.FIRST_TIME_ADD)
    Observable<String> FIRST_TIME_ADD(@Body BuildingUserIdReq req);

    @POST(NetConstantValue.WATER_DELIVERY_DEL_TASK)
    Observable<String> WATER_DELIVERY_DEL_TASK(@Body RecordIdReq req);

    @POST(NetConstantValue.GET_WATER_DELIVERY_INFO)
    Observable<String> GET_WATER_DELIVERY_INFO(@Body RecordIdReq req);

}

