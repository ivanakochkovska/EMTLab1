import React from 'react'
import axios from 'axios';
import { useState, useEffect } from 'react'
import EditBook from "./EditBook";
export const BooksTable = () => {
    const [data, getData] = useState([]);
    useEffect(() => {
        axios.get('/books').then(response => {
            getData(response.data);
        });
    },[]);
   const deleteBook =(id)=> {
       axios.delete(`/book/${id}`)
    }
    const refresh=()=>{
       window.location.reload(true);
    }
    const markAsTaken = (id) => {
       axios.get(`/book/${id}`);
    }
    return(
        <>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Available Samples</th>
                    <th>Category</th>
                </tr>
                </thead>
                <tbody>
                {data.map(
                    book =>
                        <tr id="one">
                            <td>{book.id}</td>
                            <td>{book.name}</td>
                            <td>{book.authorList}</td>
                            <td>{book.availableCopies}</td>
                            <td>{book.category}</td>
                            <td>
                                <button className="btn btn-primary btn-sm" onClick={()=> {deleteBook(book.id); refresh()}}  >Delete
                                </button>
                            </td>
                            <td>
                                <button className="btn btn-primary btn-sm" >Edit
                                </button>
                                <EditBook previousBook={book}/>
                            </td>
                            <td>
                                <button className="btn btn-primary btn-sm"
                                        onClick={()=> {markAsTaken(book.id); refresh()}}>Mark as taken
                                </button>
                            </td>
                        </tr>
                )};
                </tbody>
            </table>

        </>
    );
}
// class BooksTable extends React.Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             data: []
//         }
//     }
//     componentDidMount() {
//         axios.get("/books").then(res => console.log(res.data));
//     }
// render() {
//         return(
//             <div></div>
//         );
// }
// }
export default BooksTable;