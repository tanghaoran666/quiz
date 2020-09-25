import React from 'react';
import './Order.css';


class Order extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="order">
        <div className='orderName'>{this.props.name}</div>
        <div className='price'>{this.props.price}</div>
        <div className='orderNumber'>{this.props.number}</div>
        <div className='size'>瓶</div>
        <button onClick={this.props.handleCart}>删除</button>
      </div>
    );
  }
}

export default Order;