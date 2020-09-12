<template>
  <footer class="footer">
    <div class="container-fluid d-flex flex-wrap justify-content-between">
      <nav>
        <ul>
          <li>
            <router-link :to="{path:'/dashboard'}">야타랑 여행 한번 가볼텨?</router-link>
          </li>
        </ul>
      </nav>
      <div class="copyright d-flex flex-wrap">
        &copy; Coded with
        <i class="fa fa-heart heart"></i> by
        <a href="https://github.com/insukChoi/yata" target="_blank"> &nbsp; YATA.</a>&nbsp;
        Designed by <a href="https://github.com/insukChoi/yata" target="_blank">&nbsp; YATA Team.</a>
      </div>
    </div>
  </footer>
</template>
<script>
export default {};
</script>
<style>
</style>
