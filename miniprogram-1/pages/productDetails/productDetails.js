// pages/productDetails/productDetails.js
var wxCharts = require("../../utils/wxcharts.js");
var yuelineChart=null;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imageWidth:0,
    like_url:'/images/tabs/heart.png',
    like_state:false,
    like:35,
    dontlike_url:'/images/tabs/heart_broken.png',
    dontlike_state:false,
    dontlike:10,
    shoucang_url:'/images/tabs/shoucang.png',
    shoucang_state:false
  },

like: function () { 
  if (this.data.dontlike_state) {
  }else{
    if (this.data.like_state) {
      this.setData({
         like_url: '/images/tabs/heart.png',
         like_state: false,
         like:this.data.like-1
      })
     
    } else {
      this.setData({
         like_url: '/images/tabs/zhi.png',
         like_state: true,
         like:this.data.like+1
      })
    }
    } 
  },

dontlike: function () {
   if (this.data.like_state) {
  }else{
    if (this.data.dontlike_state) {
      this.setData({
         dontlike_url: '/images/tabs/heart_broken.png',
         dontlike_state: false,
         dontlike:this.data.dontlike-1
      })
    } else {
      this.setData({
         dontlike_url: '/images/tabs/buzhi.png',
         dontlike_state: true,
         dontlike:this.data.dontlike+1
      })
    }
   }
  },

shoucang: function () {
    if (this.data.shoucang_state) {
      this.setData({
         shoucang_url: '/images/tabs/shoucang.png',
         shoucang_state: false
      })
    } else {
      this.setData({
         shoucang_url: '/images/tabs/yishoucang.png',
         shoucang_state: true
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad:function (options) {
    let that = this
    console.log("接收到的数据",options)
    let item =  JSON.parse(options.jsonStr)
    console.log('上个页面跳转的参数', item)
    wx.setStorageSync('recommend', item)
    let rec=wx.getStorageSync('recommend')
    that.setData({
      rec:item
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
   
    //折线图
  onShow() {
    var windowWidth = 300;
      try {
      var res = wx.getSystemInfoSync();
      windowWidth = res.windowWidth;
      } catch (e) {
      console.error('getSystemInfoSync failed!');
      }
      yuelineChart = new wxCharts({ //当月用电折线图配置
      canvasId: 'yueEle',
      type: 'line',
      categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'], //categories X轴
      animation: true,
      series: [{
        name: '每日最低',
        data: 
        [10,20,15,10,11,
        16,12,15,16,17,
        12,16,10,10,10,
        16,10,12,16,10,
        10,10,16,10,12,
        16,10,10,10,16,
        10,30],
        format: function (val, name) {
        return val + '';
        }
      },
      ],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '价格（元）',
        format: function (val) {
        return val;
        },
        /*max: 20,*/
        min: 0
      },
      width: windowWidth,
      height: 200,
      dataLabel: false,
      dataPointShape: true,
      extra: {
        lineStyle: 'curve'
      }
      });
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