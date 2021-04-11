import React from 'react'
import axios from "axios";
class EditBook extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            isFormVisible: false,
            name: '',
            authorList: '',
            category: '',
            availableCopies: '',
            previousBook: this.props.previousBook,
        }
    }
    onFormSubmit(id,name, authorList, availableCopies, category) {
        axios.post(`/update/${id}`,{params: {
            availableCopies: availableCopies,
              category: category,
              name: name
        }});
    }
    refresh=()=> {
        window.location.reload(true);
    }
    render() {
        return(
            <>
                <div>
                    <form onSubmit={this.onFormSubmit}>
                        <div className="form-group">
                            <label>ID: </label>
                            <input type="text" className="form-control" id="exampleInputEmail1"
                                   value={this.state.previousBook.id}/>
                        </div>
                        <div className="form-group">
                            <label>Name: </label>
                            <input type="text" className="form-control" id="exampleInputEmail1"
                                   onChange={(event => {
                                       this.setState({name: event.target.value})
                                   })} value={this.state.previousBook.name}/>
                        </div>
                        <div className="form-group">
                            <label>Author: </label>
                            <input type="text" className="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp"
                                   onChange={(event => {
                                       this.setState({authorList: event.target.value})
                                   })}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="exampleInputEmail1">AvailableCopies: </label>
                            <input type="text" className="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp"
                                   onChange={event => {
                                       this.setState({availableCopies: event.target.value})
                                   }}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="exampleInputPassword1">Category: </label>
                            <input type="password"  className="form-control" id="exampleInputPassword1"
                                   onChange={event => {
                                       this.setState({category: event.target.value})
                                   }}

                            />
                        </div>
                        <button type="submit" className="btn btn-primary" onClick={()=>{this.onFormSubmit(this.state.name,this.state.authorList,this.state.availableCopies
                        ,this.state.category);this.refresh()}}/>
                        <br/><br/><br/>
                        <div>{this.state.message}</div>
                    </form>
                </div>
            </>
        )
    }

}
export default EditBook;