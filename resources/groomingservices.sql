SELECT DC.DaycareName, SS.SubServiceName FROM OakesDB.Daycare DC INNER JOIN OakesDB.DaycaretoService DS ON DC.DaycareID = DS.DaycareID INNER JOIN OakesDB.ServiceCategory SC ON DS.ServiceID = SC.ServiceCatID INNER JOIN OakesDB.City C ON C.LocationID = DC.LocationID INNER JOIN OakesDB.SubService SS ON SS.ServiceID = DS.ServiceID AND DS.SubServiceID = SS.ServiceSubCatID WHERE SC.CategoryName = 'Grooming' AND C.CityName = 'Seattle';