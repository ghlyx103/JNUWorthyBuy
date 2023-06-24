// pages/Administer/ProductsIsApproved/ProductsIsApproved.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    productList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    // 调用后端接口获取商品数据
    wx.request({
      url: 'http://172.26.147.101:9988/demo/getProductList',
      method: 'GET',
      data: {
        list:3,
        good_position:0
      },
      header: {
        'Content-Type': 'application/json'
      },
      success: (res) => {
        console.log(res);
        console.log(res.data);
        // 获取到商品数据后，将数据赋值给 productList
        this.setData({
          productList: res.data
        });
      },
      fail: (error) => {
        console.log(error);
      }
    });
  },

  //审核商品函数
  approveProduct: function(event) {
    var productId = event.currentTarget.dataset.id;

    // 根据 productId 找到对应的商品对象
    var product = this.data.productList.find(item => item.wx_id === productId);
    if (!product) {
      return; // 商品不存在，不执行后续操作
    }

    // 修改商品的审核状态为 1（通过）
    product.status = 1;

    // 调用后端接口更新商品的审核状态为 1（通过）
    wx.request({
      url: 'http://172.26.196.9:9988/demo/reviewProduct',
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
        wx_id: productId,
        status: 1
      },
      success: (res) => {
        console.log(res.data);

        // 从商品列表中移除已审核通过的商品
        var updatedProductList = this.data.productList.filter(item => item.wx_id !== productId);

        this.setData({
          productList: updatedProductList
        });

        wx.showToast({
          title: '审核通过',
          icon: 'success'
        });
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

  //驳回商品函数
  rejectProduct: function(event) {
    var productId = event.currentTarget.dataset.id;

    // 根据 productId 找到对应的商品对象
    var product = this.data.productList.find(item => item.wx_id === productId);
    if (!product) {
      return; // 商品不存在，不执行后续操作
    }

    // 修改商品的审核状态为 -1（驳回）
    product.status = -1;

    // 调用后端接口更新商品的审核状态为 -1（驳回）
    wx.request({
      url: 'http://172.26.196.9:9988/demo/reviewProduct',
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
        wx_id: productId,
        status: -1
      },
      success: (res) => {
        console.log(res.data);

        // 从商品列表中移除已驳回的商品
        var updatedProductList = this.data.productList.filter(item => item.wx_id !== productId);

        this.setData({
          productList: updatedProductList
        });

        wx.showToast({
          title: '商品已驳回',
          icon: 'success'
        });
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