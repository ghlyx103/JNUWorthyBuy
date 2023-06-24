// pages/personal/personal.js
Page({


  /**
   * 页面的初始数据
   */
  data: {
    chooseIncome:true,
    chooseExpenditure:false,
    //声明一个 dataList 变量

  },
  Income:function(){
    wx.clearStorage(),
    this.setData({
      chooseIncome:true,
      chooseExpenditure:false,
    })
  },
  Expenditure:function(){
    wx.clearStorage(),
    this.setData({
      chooseIncome:false,
      chooseExpenditure:true,
    })

  },

skip(e){
  var id = e.currentTarget.dataset.id
  console.log(id)
  const data= JSON.stringify(this.data.dataList[id]);

    wx.navigateTo({
    url: '/pages/productDetails/productDetails?jsonStr=' + data ,
  })
},



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    wx.request({
      url: 'http://172.26.147.20:9988/demo/getUserProductList', 
      method: 'get',
      data:{
        type :"Pgoods",
        wx_id:""
      },
      header: {
        'Content-Type': 'application/json'
      },
      success:(res)=> {
        console.log(res);
        console.log(res.data);
        this.setData(
         {
          dataList:res.data
         }
      );
      console.log(this.data.dataList)
        // 处理返回的数据
      },
      fail: (res)=> {
        console.log(res);
        console.log(res.errMsg);
        // 处理请求失败的情况
      }
    })
    },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})