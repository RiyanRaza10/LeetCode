class BrowserHistory {
    List<String> webPages = new ArrayList<>();
    int curr = 0;

    public BrowserHistory(String homepage) {
        webPages.add(homepage);
    }
    
    public void visit(String url) {
        // Remove all forward pages
        while(webPages.size() > curr+1) webPages.removeLast();
        
        // Add current url
        webPages.add(url);
        curr = webPages.size()-1;
    }
    
    public String back(int steps) {
        // Steps out of bounds , return starting page
        if(curr - steps < 0){
            curr = 0;
            return webPages.get(0);
        }

        curr -= steps;
        return webPages.get(curr);
    }
    
    public String forward(int steps) {
        // Steps out of bounds , return last page
        if(curr + steps >= webPages.size()){
            curr = webPages.size()-1;
            return webPages.get(webPages.size()-1);
        }

        curr += steps;
        return webPages.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */