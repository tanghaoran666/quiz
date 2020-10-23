import React from "react";
import { NavLink } from "react-router-dom";
import "./Home.css";
import Good from "./Good";
class Home extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="home">
        {this.props.goods.map((item) => (
          <Good
            handleCart={this.handleCart}
            name={item.name}
            price={item.price}
            key={item.name}
            url={item.url}
          />
        ))}
      </div>
    );
  }
}

export default Home;
