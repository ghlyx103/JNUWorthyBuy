// pages/comment/comment.js
Page({

  /**
   * 页面的初始数据
   */
// 用于格式化时间戳


  onAddcomment:function(event){
    wx.navigateTo({
      url: '/pages/addcomment/addcomment',
    })
  },


  data: {
    CommentList:"",
    CommentDate:"",
    Profile:"",

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const that = this
    wx.request({
      url: 'http://172.26.196.145:9988/demo/getCommentList',
      header: {
        "Content-Type": "application/json"
      },
      method: "POST",
      data: "小猪佩奇",
      success: function (res) {
        console.log(res);
        console.log(res.data);
        console.log(res.data[0].comment_date);
        console.log(typeof res.data[0].comment_date);
        let DateList = []
        for(let i = 0;i <res.data.length;i++){
          let Date_n = new Date(res.data[i].comment_date)  
          console.log(Date_n) 
          DateList.push(Date_n.getFullYear()+"-"+(Date_n.getMonth()+1)+"-"+Date_n.getDate()+" "+Date_n.getHours("hh")+":"+Date_n.getMinutes("mm"))
          console.log(DateList) 
        }
        console.log(DateList)
        that.setData({
          CommentList: res.data
        })
        that.setData({
          CommentDate:DateList
        })

          // wx.showToast({
          //   title: '提交成功！！！',
          //   icon: 'loading',
          //   duration: 1500
          // })
      },
      fail:function(res){
        console.log(res);
          wx.showToast({
            title: '拉取评论列表失败！！！',
            icon: 'loading',
            duration: 1500
          })
      }
})

wx.cloud.init({
  env: 'teamwork-4gwb300bcce93fe7'
})
wx.cloud.getTempFileURL({
  fileList: ['	cloud://teamwork-4gwb300bcce93fe7.7465-teamwork-4gwb300bcce93fe7-1317567512/头像.png'],
  success: res => {
    // fileList 是一个有如下结构的对象数组
    // [{
    //    fileID: 'cloud://xxx.png', // 文件 ID
    //    tempFileURL: '', // 临时文件网络链接
    //    maxAge: 120 * 60 * 1000, // 有效期
    // }]
    console.log(res.fileList[0].tempFileURL)
    that.setData({
      Profile:res.fileList[0].tempFileURL
    })
  },
  fail: console.error
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