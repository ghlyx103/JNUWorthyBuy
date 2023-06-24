// pages/Administer/UserCommentManagement/UserCommentManagement.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nicheng:'',
    touxiang:'user003',
    shoujihao:0,
    uesr_publish:false,
    uesr_comment:false
  },
  /**
   * 获取User数据
   */
  get_User() {
    wx.request({
      url: 'http://172.26.196.9:9988/demo/getUser',
      method: 'GET',
      header: {
        'Content-Type': 'application/json'
      },
      success: (res) => {
        var responseData=res.data;
        console.log(res);
        console.log(responseData);
        this.setData(
          {
           nicheng:responseData.user_name,
           touxiang:'user003',
           shoujihao:responseData.phonr,
           uesr_publish:responseData.uesr_publish,
           uesr_comment:responseData.uesr_comment
          }
       );
      },
      fail: (error) => {
        console.log(error);
      },
    });
  },
  toggleRecommendPermission: function() {
    var uesr_publish = this.data.uesr_publish;
    var uesr_comment = this.data.uesr_comment;

    // 调用后端接口，传递用户ID和评论权限状态
    wx.request({
      url: 'http://172.26.196.9:9988/demo/modifyUser',
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
        wx_id:1003,
        uesr_comment: uesr_comment,
        uesr_publish: !uesr_publish // 切换评论权限状态
      },
      success: (res) => {
        console.log(res.data); // 打印接口返回的数据

        // 根据接口返回的结果更新评论权限状态
        if (true) {
          this.setData({
            uesr_publish: !uesr_publish
          });

          wx.showToast({
            title: '操作成功',
            icon: 'success'
          });
        } else {
          wx.showToast({
            title: '操作失败',
            icon: 'none'
          });
        }
      },
      fail: (error) => {
        console.log(error);
        wx.showToast({
          title: '请求失败',
          icon: 'none'
        });
      }
    });
  },
  toggleCommentPermission: function() {
    var uesr_publish = this.data.uesr_publish;
    var uesr_comment = this.data.uesr_comment;

    // 调用后端接口，传递用户ID和评论权限状态
    wx.request({
      url: 'http://172.26.196.9:9988/demo/modifyUser',
      method: 'POST',
      data: {
        wx_id:1003,
        uesr_publish: uesr_publish,
        uesr_comment: !uesr_comment // 切换评论权限状态
      },
      success: (res) => {
        console.log(res.data); // 打印接口返回的数据

        // 根据接口返回的结果更新评论权限状态
        if (true) {
          this.setData({
            uesr_comment: !uesr_comment
          });

          wx.showToast({
            title: '操作成功',
            icon: 'success'
          });
        } else {
          wx.showToast({
            title: '操作失败',
            icon: 'none'
          });
        }
      },
      fail: (error) => {
        console.log(error);
        wx.showToast({
          title: '请求失败',
          icon: 'none'
        });
      }
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.get_User()
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