package sg.edu.iss.club.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.domain.BookingStatus;
import sg.edu.iss.club.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  BookingRepository bookingRepository;

  @Transactional
  public void addBooking(Booking booking) {
    bookingRepository.save(booking);
  }

  @Transactional
  public boolean isAvailable(Booking booking) {
    LocalDate current = booking.getStartDate();
    
    while (current.isBefore(booking.getEndDate()) || current.isEqual(booking.getEndDate())) {
      List<Booking> bookingsAtTheDay = bookingRepository.findBooking(current, booking.getFacility().getId());
      for (Booking bookingAtTheDay : bookingsAtTheDay) {
        if (bookingAtTheDay.getStatus().equals(BookingStatus.BOOKED)) {
          // There is some booking at the same day already
          return false;
        }
      }
      
      current = current.plusDays(1);
    }
    
    return true;
  }

  @Transactional
  public void cancelBooking(Booking booking) {
    booking.setStatus(BookingStatus.CANCELED);
    bookingRepository.save(booking);
  }

  @Transactional
  public List<Booking> listBooking() {
    return bookingRepository.findAll();
  }

  @Transactional
  public Booking findBookingById(Integer id) {
    return bookingRepository.findById(id).get();
  }

}
