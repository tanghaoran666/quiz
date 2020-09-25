import React from 'react';
import './Orders.css';


class Orders extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="orders">
        <div className='orderTitle'>
            <div className='desc'>名字</div>
            <div className='desc'>单价</div>
            <div className='desc'>数量</div>
            <div className='desc'>单位</div>
            <div className='desc'>操作</div>
        </div>
      </div>
    );
  }
}

export default Orders;