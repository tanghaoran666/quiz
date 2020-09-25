import React from 'react';
import './Good.css';


class Good extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="good">
        <img className="phoneImg" src={this.props.url} />
        <div>{this.props.name}</div>
        <div className='price'>单价：</div>
        <p className='price'>{this.props.price}</p> <div className='price'>元/瓶</div>
        <button onClick={this.props.handleCart}>add to cart</button>
      </div>
    );
  }
}

export default Good;