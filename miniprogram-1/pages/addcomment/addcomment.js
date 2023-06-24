// pages/addcomment/addcomment.js
Page({

  /**
   * 页面的初始数据
   */

  gotoIndex: function(option) {   
    wx.switchTab({      
        url: '/pages/index/index',    //要跳转到的页面路径，注意此时的路径中不要出现文件扩展名，要与app.json中的路径一致
  })  
  },
  gotoSuccessfullyComment: function(option) {   
    wx.navigateTo({      
        url: '/pages/commentSuccessfully/commentSuccessfully',    //要跳转到的页面路径
      })  
    },

    formSubmit: function (e) {
        // console.log(e)
        // console.log(e.detail)
        // console.log(e.detail.value)
        let riqi = new Date
        console.log(riqi)
        let newdata={goods_name:"xxx",comment_id:111,comment_date:riqi,comment:e.detail.value.comment}
      wx.request({
        url: 'http://172.26.196.9:9988/demo/addComment',
        header: {
          "Content-Type": "application/json"
        },
        method: "POST",
        data: newdata,
        success: function (res) {
          console.log(res);
            wx.showToast({
              title: '提交成功！！！',
              icon: 'loading',
              duration: 1500
            })
        },
        fail:function(res){
          console.log(res);
            wx.showToast({
              title: '提交失败！！！',
              icon: 'loading',
              duration: 1500
            })
        }
  })
  },
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

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