import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import API from '../api';
import Header from '../components/Header';
import Booking from '../components/Booking';

function ListBooking() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [role] = useState(localStorage.getItem("role"));
    const [bookings, setBookings] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const token = localStorage.getItem("jwtToken");
        setIsLoggedIn(!!token);

        if((role=="admin")|| (role=="manager")|| (role=="personel")){
            navigate("/admin-panel")
        }
    
        if (!token) {
            navigate("/");
        } else {
            const id = localStorage.getItem("id");
    
            if (id) {
                API.get(`booking/customer/${id}`)
                    .then(response => {
                        setBookings(response.data);
                        console.log(response);
                        
                    })
                    .catch(error => {
                        console.error("Error fetching bookings:", error);
                    });
            }
        }
    }, [navigate]);

    return (
        <div>
            {isLoggedIn && bookings.length > 0 ? (
                <>
                <Header isLoggedIn={isLoggedIn}/>
                <Booking bookings={bookings} />
                </>
                ) : (
                    <>
                    <Header isLoggedIn={isLoggedIn}/>
                    <br /><br />
                    <h2 style={{margin:"25% 40%"}}>No bookings found or you're not logged in.</h2>
                    </>
                )}
        </div>
    );
}

export default ListBooking;
