import React from "react";
import { NavLink} from 'react-router-dom';
import './Header.css';

class Header extends React.Component{
    render(){
        return <div className='links'>
            <div className='linkBlock'>
            
            <div className='link'>
            <NavLink classname='menu-link' to="/" activeStyle={{textDecoration: "underline"}}>商城</NavLink>
            </div>
            <div className='link'>
            <NavLink classname='menu-link' to="/order" activeStyle={{textDecoration: "underline"}}>订单</NavLink>
            </div>
            <div className='link'>
            <NavLink classname='menu-link' to="/add" activeStyle={{textDecoration: "underline"}}>添加商品</NavLink>
            </div>
            
            </div>
        </div>
    }
}

export default Header;