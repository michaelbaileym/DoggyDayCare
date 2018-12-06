SELECT DC.DaycareName, C.CityName FROM OakesDB.Daycare DC INNER JOIN OakesDB.City C ON DC.LocationID = C.LocationID INNER JOIN OakesDB.DaycareToAmmenity DA ON DC.DaycareID = DA.DaycareID INNER JOIN OakesDB.AmmenitiesProvided AP ON DA.AmmenityID = AP.idAmmenityID WHERE AP.AmmenityDesc = "Webcam";