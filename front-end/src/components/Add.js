import React, { Component } from "react";
import "./Add.css";

class Add extends Component {
  state = {
    name: "",
    price: "",
    unit: "",
    url: "",
  };

  handleChange = (event) => {
    event.preventDefault();
    this.setState({ [event.target.name]: event.target.value });
  };
  handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const data = await fetch("http://localhost:8080/good", {
        method: "POST",
        body: JSON.stringify({
          name: this.state.name,
          price: this.state.price,
          unit: this.state.unit,
          url: this.state.url,
        }),
        headers: {
          "Content-Type": "application/json",
        },
      });
      const result = await data.json();
      console.log(JSON.stringify(result));
    } catch (err) {
      console.log(err);
    }
    console.log(JSON.stringify(this.state));
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          * 名称:
          <br />
          <input
            type="text"
            name="name"
            onChange={this.handleChange}
            value={this.state.name}
            placeholder="货品名称"
            className="input"
          />
        </label>
        <br />
        <label>
          * 价格:
          <br />
          <input
            type="text"
            name="price"
            onChange={this.handleChange}
            value={this.state.price}
            placeholder="价格"
            className="input"
          />
        </label>
        <br />
        <label>
          * 单位:
          <br />
          <input
            type="text"
            name="unit"
            onChange={this.handleChange}
            value={this.state.unit}
            placeholder="单位"
            className="input"
          />
        </label>
        <br />
        <label>
          * 图片:
          <br />
          <input
            type="text"
            name="url"
            onChange={this.handleChange}
            value={this.state.url}
            placeholder="图片地址"
            className="input"
          />
        </label>
        <br />
        <input
          type="submit"
          value="Submit"
          disabled={
            !this.state.name ||
            !this.state.price ||
            !this.state.unit ||
            !this.state.url
          }
        />
      </form>
    );
  }
}

export default Add;
