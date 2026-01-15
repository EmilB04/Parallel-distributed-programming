#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define NUM_OF_THREADS 100

void *PrintMessage(void *ThreadId){
  long tid;
  tid = (long)ThreadId;
  printf("Hello World from Thread #%ld!\n", tid);
  printf("Another message from Thread #%ld!\n", tid);
  printf("\n");

}
int main (int argc, char *argv[]){
  pthread_t threads[NUM_OF_THREADS];
  int ret;
  long i;
  for(i=0; i<NUM_OF_THREADS; i++){
    printf("Creating Thread %ld in the main() function\n", i);
    ret = pthread_create(&threads[i], NULL, PrintMessage, (void *)i);
    if (ret){
      printf("ERROR in creating thread; return ERROR code %d\n", ret);
      exit(-1);
    }
    //sleep(10);
  }
pthread_exit(NULL);
return 0;
}
