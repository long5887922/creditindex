package com.zy.creditindex.repostory.indexJpa;

import com.zy.creditindex.entity.idri.BastrdtInfoBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by huaqin on 2017/10/31.
 */
@Repository
public interface BastrdtInfoRepostory extends JpaRepository<BastrdtInfoBean,String>{
    /*通过日期查询交易日*/
    @Query(value="SELECT bs.id,bs.NORM_DAY,bs.EXCH_CODE,bs.NXT_DAY,bs.PRE_DAY,bs.IS_TRD_DAY,bs.THIS_W,bs.TRD_DAY,bs.THIS_W_N,bs.THIS_M_N,bs.LST_W_DAY,bs.LST_M_DAY,bs.LST_Y_DAY,bs.IS_END_W,bs.IS_END_M,bs.IS_END_Q,bs. IS_END_Y,bs.IS_LST_END_M,bs.IS_LST_END_Q,bs.ENT_TIME,bs.UPD_TIME,bs.GRD_TIME,bs.RS_ID,bs.REC_ID,bs.B_5D_DAY,bs.B_10D_DAY,bs.B_1M_DAY,bs.B_2M_DAY,bs.B_3M_DAY,bs.N_TRD_DAY_TYP FROM BAS_TRDT_INFO bs  WHERE bs.NORM_DAY=?1 and bs.EXCH_CODE in('101','105')",nativeQuery = true)
    public BastrdtInfoBean queryStartTime(Date dateTime);
    /*查询10天前的交易日*/
    @Query(value="SELECT  bs.id,bs.NORM_DAY,bs.EXCH_CODE,bs.NXT_DAY,bs.PRE_DAY,bs.IS_TRD_DAY,bs.THIS_W,bs.TRD_DAY,bs.THIS_W_N,bs.THIS_M_N,bs.LST_W_DAY,bs.LST_M_DAY,bs.LST_Y_DAY,bs.IS_END_W,bs.IS_END_M,bs.IS_END_Q,bs. IS_END_Y,bs.IS_LST_END_M,bs.IS_LST_END_Q,bs.ENT_TIME,bs.UPD_TIME,bs.GRD_TIME,bs.RS_ID,bs.REC_ID,bs.B_5D_DAY,bs.B_10D_DAY,bs.B_1M_DAY,bs.B_2M_DAY,bs.B_3M_DAY,bs.N_TRD_DAY_TYP FROM BAS_TRDT_INFO bs  WHERE NORM_DAY<=?1 and EXCH_CODE in('101','105') and is_trd_day='1' ORDER BY trd_day DESC limit 9,1",nativeQuery = true)
    public BastrdtInfoBean queryBeforTime(Date dateTime);
    @Query(value="SELECT  bs.id,bs.NORM_DAY,bs.EXCH_CODE,bs.NXT_DAY,bs.PRE_DAY,bs.IS_TRD_DAY,bs.THIS_W,bs.TRD_DAY,bs.THIS_W_N,bs.THIS_M_N,bs.LST_W_DAY,bs.LST_M_DAY,bs.LST_Y_DAY,bs.IS_END_W,bs.IS_END_M,bs.IS_END_Q,bs. IS_END_Y,bs.IS_LST_END_M,bs.IS_LST_END_Q,bs.ENT_TIME,bs.UPD_TIME,bs.GRD_TIME,bs.RS_ID,bs.REC_ID,bs.B_5D_DAY,bs.B_10D_DAY,bs.B_1M_DAY,bs.B_2M_DAY,bs.B_3M_DAY,bs.N_TRD_DAY_TYP FROM BAS_TRDT_INFO bs  WHERE bs.trd_day >=?1 and bs.TRD_DAY<=?2 and bs.EXCH_CODE in('101','105')  and bs.IS_TRD_DAY='1' ORDER BY bs.TRD_DAY ASC",nativeQuery = true)
    public List<BastrdtInfoBean> findWithinTenDay(Date startTime,Date endTime);
}
