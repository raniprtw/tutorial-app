import React from "react";
import List from "./components/List"
import dummyItems from "./items.json"
//import logo from './logo.svg';
//import './App.css';

/*function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
*/

export default class App extends React.Component{
  render(){
    return(
      <div className="container-fluid">
        <h1 className="text-center">
          Welcome!
          <small>Class-based</small>
        </h1>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List title="Our Menu" items={dummyItems} onItemClick={() => {}}/>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
