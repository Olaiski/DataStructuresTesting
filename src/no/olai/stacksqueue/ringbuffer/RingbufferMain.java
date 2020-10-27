package no.olai.stacksqueue.ringbuffer;


class RingbufferMain {
    public static void main(String[] args) {


        Ringbuffer<Integer> ringbuffer = new Ringbuffer<>(5);
        ringbuffer.offer(1);
        ringbuffer.offer(2);
        ringbuffer.offer(3);
        ringbuffer.offer(4);
        ringbuffer.offer(5);
        ringbuffer.poll();




        System.out.println(ringbuffer);
    }
}
