# AddAudioInApp
How to integrate in app audio (simple : without audio controls )


 Step 1 : create the buttons to control the play and pause actions for the audio

 Step 2 : Declare a media player object ( this will hold the song in it )

 Step 3 : In the oncreate method , Initialize the media player object by using the create method and mentioning
 the context as "this" app and the destination of the song as second param

 Step 4 : call the start() function on the media player to start the song

 Step 5 : call the pause function on the mediaplayer in the onclick method
 which is connected to the pause button

   //Controlling the volume :

 Step 6 : add a seekbar widget to the layout which will be responsible for controlling the volume of the audio

 Step 7 : add a seekbar object to the MainActivity class (name it volumeSeekBar for convenience )

 Step  8 : connect volume source to the volume seek bar by using findViewById() method

 Step 9 : enable the onSeekBar to control audio by implementing an anonymous onSeekBarChangeListener ,
  by using the setOnSeekBarListener. The onProgressChanged method of the volumeSeekBar wil be used to control the sound of the audio

 Step 10 : to establish that the  onSeekBarChangeListener has been properly set up  ,
  log the values of progressChanged

 Step 11 : Define an audio manager object which will be responsible for controlling the  dynamic playing of the audio ,

 Step 11 b : initialize audioManager object  in the onCreate method ,
 using the getSystemService method and using the param AudioService ,
 and casing the object we get to AudioManager

 Step 12 : To get the maximum volume of the specific phone , define an int variable in the onCreate method  ,
 and extract the music max volume of the specific device using the audio manager object ,
  and using the getStreamMaxVolume and specifying the param (StreamMusic)

  Step 13 : use the volumeSeekBar's setMax() mathod the set the max volume of the phone to it

  Step 14 : now ,in the onProgressChanged method in the onSeekBarChanged listener ,
  call the setStreamVolume method of the audioManager and then in the first param ,
  set the type of audio stream ( here it's StreamMusic ) ,
  in the second param , set the progress ,
  and the 3 rd flag , keep it 0

  Step 15 : To enable the sound of any new song to have the same sound in accordance to where the slider is placed initially ,
  first  , we'll need to extract the currentVolume using the audio manager and put it in an int variable currentVolume and
  use the getStreamVolume method of audioManager and use the StreamMusic parameter value to get the current volume .

  Step 16 : Now to set the seekBar position in accordance to the current volume ,
  use the setProgress() method of the audioManager  and pass the currentVolume variable as the parameter .

  // For Seeking back and forth across the song :

  Step 17 : To seek back and forth across a music file , you need to define another seek bar in the layout file

  Step 18,19,20 : are the same as the ones used for the volumeSeekBar

  Step 21 : next , you  need to set the maximum value of the seek bar equal to the total length of the audio being played ,
  for that you can define the int songLength and extract it using the mediaPlayer object's method  getDuration() ,
  which gives the length of the song as an int .

  Step 22 : now, as you had set the max value of the progress bar using the setMax() method for volume ,
  similarly , use the setMax() method to set the max of the scrubSeekBar by passing in the songLength variable as parameter .

  Step 23 : now , to regularly update the seek bar as we're naturally moving along the length of the song ,
   or seeking back and forth through the scrubSeekBar ,
  we need to define a Timer object ( this allows us to do something every time slot(min/sec ...etc ) ,
  which will update the progress bar as the song moves forward .
  The timer object will use the scheduleAtFixedRate method to invoke an anonymous class Timer task ( which has 3 parameters ,
   the second param is when to start ( 0  means start right now ) , the third param is the interval of recurrence ( 10000 means 1 sec  ) )
  ,the first param is a method run () which is used to specify the interval after which an activity is repeated ( here scrubSeekBar position )

   Step 24 : next , to update the position of the seek bar as the music plays ,
    use the scrubSeekBar's setProgress method and then pass in the currentPosition of the song playing by using the
    getCurrentPosition() method of the mediaPlayer object

Step 25 : next , to change the position of the song  as you move the seek bar , use the method seekTo() of the mediaplayer
    object and pass in the value of the seekbar's current position by using the seekbar's getProgress() method
   
   **bug : there are hickups in the song  whenever the recurring update of the seekbar is scheduled ...

