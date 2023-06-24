// home.js
// 获取应用实例
const app = getApp()

Page({ 
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName'), // 如需尝试获取用户信息可改为false
    
    chooseIncome:true,
    chooseExpenditure:false,
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
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  Get(){
    wx.request({
      url: 'http://172.26.196.145:9988/demo/getProductList?list=3',
      method: 'GET',
      header: {
        'Content-Type': 'application/json'
      },
      success: function(res) {
        console.log(res);
        console.log(res.data);
        this.setData(
          {
           dataList:res.data
          })
        // 处理返回的数据
      },
      fail: function(res) {
        console.log(res);
        console.log(res.errMsg);
        // 处理请求失败的情况
      }
    })
  },
  onLoad() {
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    
    // 获取后端数据
    wx.request({
      url: 'http://172.26.196.145:9988/demo/getProductList',
      method: 'GET',
      data: {
        list:1,
        good_position:0
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
    },
      fail: function(res) {
        console.log(res);
        console.log(res.errMsg);
        // 处理请求失败的情况
      }
    })
  },

  skip(e){
    var id = e.currentTarget.dataset.id
    console.log(id)
    const data= JSON.stringify(this.data.dataList[id]);
  
      wx.navigateTo({
      url: '/pages/productDetails/productDetails?jsonStr=' + data 
    })
    // 
  },
  // getUserProfile(e) {
  //   // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
  //   wx.getUserProfile({
  //     desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
  //     success: (res) => {
  //       console.log(res)
  //       this.setData({
  //         userInfo: res.userInfo,
  //         hasUserInfo: true
  //       })
  //     }
  //   })
  // },
//   getUserInfo(e) {
//     // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
//     console.log(e)
//     this.setData({
//       userInfo: e.detail.userInfo,
//       hasUserInfo: true
//     })
//   }
})
