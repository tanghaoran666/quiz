import React from 'react';
import './Good.css';


class Phone extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="good">
        <img className="phoneImg" src={this.props.url} />
        <div>{this.props.name}</div>
        <div>单价：</div>
        <p>{this.props.price}</p> <div>元/瓶</div>
        <button onClick={this.props.handleCart}>add to cart</button>
      </div>
    );
  }
}

export default Phone;